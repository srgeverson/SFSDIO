package br.com.sfdio.java_avancado;

public class CriandoPrimeiraThread {

	public CriandoPrimeiraThread(Boolean primeiraSolucao) {
		if (primeiraSolucao) {
			System.out.println("Iniciando CriandoPrimeiraThread...");
			GerarRelatorioPDF2 gerarRelatorioPDF2 = new GerarRelatorioPDF2();
			gerarRelatorioPDF2.start();
			CarregandoPDF2 carregandoPDF2 = new CarregandoPDF2();
			carregandoPDF2.start();

			Thread thread = new Thread(new GerarRelatorioPDF());
			thread.start();
			Thread thread2 = new Thread(new ImprimirPDF());
			thread2.start();
			System.out.println("Finalizando CriandoPrimeiraThread...");
		} else {
			RealizarDownload realizarDownload = new RealizarDownload();
			realizarDownload.start();
			PreparandoDownload preparandoDownload = new PreparandoDownload(realizarDownload);
			preparandoDownload.start();
		}
	}

	public class GerarRelatorioPDF implements Runnable {

		@Override
		public void run() {
			System.out.println("GerarRelatorioPDF...");
		}

	}

	public class ImprimirPDF implements Runnable {

		@Override
		public void run() {
			System.out.println("ImprimirPDF...");
		}

	}

	public class GerarRelatorioPDF2 extends Thread {

		@Override
		public void run() {
			super.run();
			try {
				Thread.sleep(10000);
				System.out.println("GerarRelatorioPDF2..." + this.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public class CarregandoPDF2 extends Thread {

		@Override
		public void run() {
			super.run();
			try {
				Thread.sleep(5000);
				System.out.println("CarregandoPDF2..." + this.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public class PreparandoDownload extends Thread {

		private Thread thread;

		public PreparandoDownload(Thread thread) {
			this.thread = thread;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					if (!thread.isAlive())
						break;
					System.out.println("PreparandoDownload..." + this.getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public class RealizarDownload extends Thread {

		@Override
		public void run() {
			try {
				System.out.println("Início - RealizarDownload..." + this.getName());
				Thread.sleep(10000);
				System.out.println("Fim - RealizarDownload..." + this.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
