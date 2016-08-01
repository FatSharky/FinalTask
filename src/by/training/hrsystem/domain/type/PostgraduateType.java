package by.training.hrsystem.domain.type;

public enum PostgraduateType {
	NOT_ASIGN {
		{
			postgraduateType = "not assigned";
		}
	},
	ASIGN {
		{
			postgraduateType = "assigned";
		}
	},
	TO_BE_ASIGNED {
		{
			postgraduateType = "to be assigned";
		}
	};

	String postgraduateType;

	public String getPostgraduateType() {
		return postgraduateType;
	}

}
