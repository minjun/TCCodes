package designPatterns.ChainOfResponsibility;

abstract class Logger {
    public static int ERR = 3;
    public static int NOTICE = 5;
    public static int DEBUG = 7;
    protected int mask;

    // The next element in the chain of responsibility
    protected Logger next;

    public void setNext(Logger log) {
	next = log;
    }

    public void message(String msg, int priority) {
	if (priority <= mask) {
	    writeMessage(msg);
	}
	if (next != null) {
	    next.message(msg, priority);
	}
    }

    abstract protected void writeMessage(String msg);
}

class StdoutLogger extends Logger {
    public StdoutLogger(int mask) {
	this.mask = mask;
    }

    protected void writeMessage(String msg) {
	System.out.println("Writing to stdout: " + msg);
    }
}

class EmailLogger extends Logger {
    public EmailLogger(int mask) {
	this.mask = mask;
    }

    protected void writeMessage(String msg) {
	System.out.println("Sending via email: " + msg);
    }
}

class StderrLogger extends Logger {
    public StderrLogger(int mask) {
	this.mask = mask;
    }

    protected void writeMessage(String msg) {
	System.err.println("Sending to stderr: " + msg);
    }
}

public class ChainOfResponsibilityExample {

    private static Logger createChain() {
	// Build the chain of responsibility

	Logger logger = new StdoutLogger(Logger.DEBUG);

	Logger logger1 = new EmailLogger(Logger.NOTICE);
	logger.setNext(logger1);

	Logger logger2 = new StderrLogger(Logger.ERR);
	logger1.setNext(logger2);

	return logger;
    }

    public static void main(String[] args) {

	Logger chain = createChain();

	// Handled by StdoutLogger (level = 7)
	chain.message("Entering function y.", Logger.DEBUG);

	// Handled by StdoutLogger and EmailLogger (level = 5)
	chain.message("Step1 completed.", Logger.NOTICE);

	// Handled by all three loggers (level = 3)
	chain.message("An error has occurred.", Logger.ERR);
    }
}
