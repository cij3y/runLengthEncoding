package pruefung;

public class Rle {
	public static void main(String[] args) {
		//String text = "ACAAAGATGCCATTGTAA";		
		//String text = "abbcccdddd";
		String text = "ACAAGATGCCATTGTCCCCCGGCCTCCTGCTGCTGCTGCTCTCCGGG" 
				 + "GCCACGGCCACCGCTGCCCTGCCCCTGGAGGGTGGCCCCACCGGCCG"
				 + "AGACAGCGAGCATATGCAGGAAGCGGCAGGAATAAGGAAAAGCAGCCT"
				 + "CCTGACTTTCCTCGCTTGGTGGTTTGAGTGGACCTCCCAGGCCAGTGC"
				 + "CGGGCCCCTCATAGGAGAGGAAGCTCGGGAGGTGGCCAGGCGGCAGGA" 
				 + "AGGCGCACCCCCCCAGCAATCCGCGCGCCGGGACAGAATGCCCTGCAG"
				 + "GAACTTCTTCTGGAAGACCTTCTCCTCCTGCAAATAAAACCTCACCCA"
				 + "TGAATGCTCACGCAAGTTTAATTACAGACCTGTGA";
		String text2 = (compress(text));
		System.out.println("compress = "+text2);
		String text3 = (decompress(text2));
		System.out.println("decompress = "+ text3);
		int laenge = text.length();
		int laengeC = text2.length();
		int laengeD = text3.length();
		int laengeUnterschied = laenge - laengeC;
		System.out.println("Laengeunterschied = "+laengeUnterschied);
		if(laenge == laengeD) {
			System.out.println("passt");
		}
 	}	
//RLE a)	
	public static String compress (String text) {	
		int aa = 0;
		int bb = aa + 1;
		int z = 0;
		int y = 1;
		String b2 = "";
		String txt = "";
					
		while(z < text.length()) {
			
			if (bb==text.length() && y==1){
				b2 = String.valueOf(text.charAt(text.length()-1));
				txt = txt + b2;
				break;
			}
			if (bb==text.length() && y!=1){
				String y1 = String.valueOf(y);
				String y11  = String.valueOf(text.charAt(text.length()-1));
				b2 = y1+""+y11;
				txt = txt + b2;
				break;
				}
			
			if(y>1 && text.charAt(aa) != text.charAt(bb)) {
				String y2 = String.valueOf(y);
				b2 = String.valueOf(y2+""+text.charAt(aa));
				txt = txt + b2;
				y=1;
			}
			else{				
				if(text.charAt(aa) != text.charAt(bb)) {
					b2 = String.valueOf(text.charAt(aa));
					txt = txt + b2;
				}
				else {y=y+1;
				}
			}
			z= z+1;
			aa=aa+1;
			bb=bb+1;
		}
		return txt;
	}
//RLE b)
		public static String decompress (String text) {
			int i = 0;
			String txt2 = "";
			String txt3 = "";
			while (i<text.length()) {
				int y = 0;
				try {
					int j = Integer.parseInt(String.valueOf(text.charAt(i)));
					if(j<=9 && j>0) {
						while(y<=j-2) {
							txt2 = String.valueOf(text.charAt(i+1));
							y = y+1;
							txt3 = txt3 + txt2;
						continue;
						}
					}
				}catch (Exception ex) {
				txt2 = String.valueOf(text.charAt(i));
				txt3 = txt3 + txt2;
				}
			i = i+1;	
			}
	return txt3;
	}
}	

