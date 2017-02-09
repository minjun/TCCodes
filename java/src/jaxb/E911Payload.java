package jaxb;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "detail" })
@XmlRootElement(name = "payload")
public class E911Payload {
	@XmlElement(name="ResponseDetail")
	ResponseDetail detail;

	public ResponseDetail getDetail() {
		return detail;
	}

	public void setDetail(ResponseDetail detail) {
		this.detail = detail;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "address" })
	public static class ResponseDetail {
		@XmlElement(name="CorrectedAddress")
		CorrectedAddress address;


		public CorrectedAddress getAddress() {
			return address;
		}

		public void setAddress(CorrectedAddress address) {
			this.address = address;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "zip", "sta", "mcn", "stn", "prd", "hns", "hno" })
	public static class CorrectedAddress {
		@XmlElement(name="ZIP")
		private String zip;
		@XmlElement(name="STA")
		private String sta;
		@XmlElement(name="MCN")
		private String mcn;
		@XmlElement(name="STN")
		private String stn;
		@XmlElement(name="PRD")
		private String prd;
		@XmlElement(name="HNS")
		private String hns;
		@XmlElement(name="HNO")
		private String hno;

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getSta() {
			return sta;
		}

		public void setSta(String sta) {
			this.sta = sta;
		}

		public String getMcn() {
			return mcn;
		}

		public void setMcn(String mcn) {
			this.mcn = mcn;
		}

		public String getStn() {
			return stn;
		}

		public void setStn(String stn) {
			this.stn = stn;
		}

		public String getPrd() {
			return prd;
		}

		public void setPrd(String prd) {
			this.prd = prd;
		}

		public String getHns() {
			return hns;
		}

		public void setHns(String hns) {
			this.hns = hns;
		}

		public String getHno() {
			return hno;
		}

		public void setHno(String hno) {
			this.hno = hno;
		}
	}
}