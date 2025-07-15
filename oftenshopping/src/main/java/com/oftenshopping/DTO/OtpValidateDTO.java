package com.oftenshopping.DTO;

public class OtpValidateDTO {

	private String email;
	private String otp;

	public OtpValidateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OtpValidateDTO(String email, String otp) {
		super();
		this.email = email;
		this.otp = otp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OtpValidateDTO [email=" + email + ", otp=" + otp + "]";
	}

}
