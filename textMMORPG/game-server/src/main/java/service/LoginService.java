package service;

public interface LoginService {
	String login(String input, String clientId);
	String logout(String clientId);
}
