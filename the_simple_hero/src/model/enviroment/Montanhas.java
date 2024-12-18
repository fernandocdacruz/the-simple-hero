package model.enviroment;

import service.BatalhaBoss;

public class Montanhas {

		private BatalhaBoss batalha;

		public Montanhas(BatalhaBoss batalha) {
			super();
			this.batalha = batalha;
		}

		public BatalhaBoss getBatalha() {
			return batalha;
		}

		public void setBatalha(BatalhaBoss batalha) {
			this.batalha = batalha;
		}
		
}
