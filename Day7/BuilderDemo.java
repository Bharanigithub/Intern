package Day7;

public class BuilderDemo {
	public static void main(String args[]) {
		Computer com=new Computer.computerBuilder("HDD_Enabled","12GB_RAM").setBlueTooth("BlueTooth_Enabled").Build();
		System.out.println(com);
	}
}

class Computer {
	private String HDD;
	private String RAM;
	private String blueTooth;
	private String graphicsCard;
	
	public Computer(computerBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.blueTooth=builder.blueTooth;
		this.graphicsCard=builder.graphicsCard;
	}
	
	
	
	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", blueTooth=" + blueTooth + ", graphicsCard=" + graphicsCard
				+ "]";
	}



	public static class computerBuilder {
		private String HDD;
		private String RAM;
		private String blueTooth;
		private String graphicsCard;
		public computerBuilder(String HDD,String RAM) {
			this.HDD=HDD;
			this.RAM=RAM;
		}
		
		public final String getHDD() {
			return HDD;
		}

		public final void setHDD(String hDD) {
			HDD = hDD;
		}

		public final String getRAM() {
			return RAM;
		}

		public final void setRAM(String rAM) {
			RAM = rAM;
		}

		public final String getBlueTooth() {
			return blueTooth;
		}

		public final computerBuilder setBlueTooth(String blueTooth) {
			this.blueTooth = blueTooth;
			return this;
			
		}

		public final String getGraphicsCard() {
			return graphicsCard;
		}

		public final computerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}

		public Computer Build() {
			return new Computer(this);
		}
	}
}


