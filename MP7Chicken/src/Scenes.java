// Gary, JJ 2017

public class Scenes {

	public static void pr(String s) {
		long t0, t1;
	 	t0 = System.currentTimeMillis();
		do { t1 = System.currentTimeMillis();
		} while((t1-t0) < 35);
		System.out.println(s);
	}

	public static void clear() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public static void opening() {
		clear();
		pr("///////////////////////////////////////////////////////////////////////////////");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                  *************   Chicken  *************                   //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                  **************************************                   //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("//                                                                           //");
		pr("///////////////////////////////////////////////////////////////////////////////");
	}


}
