package by.training.hrsystem.domain.type;

public enum EmploymentType {
	FULL_TIME {
		{
			currencyType = "fulltime";
		}
	},
	PART_TIME {
		{
			currencyType = "parttime";
		}
	},
	CONTRACTUAL {
		{
			currencyType = "contractual";
		}
	};

	String currencyType;

	public String getCurrencyType() {
		return currencyType;
	}

}
