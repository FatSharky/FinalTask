package by.training.hrsystem.domain.type;

public enum PassType {
	PASS {
		{
			passType = "pass";
		}
	},
	NOT_PASS {
		{
			passType = "not pass";
		}
	};
	String passType;

	public String getPassType() {
		return passType;
	}

}
