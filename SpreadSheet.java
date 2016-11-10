import java.io.*;
import java.util.*;
 
public class jam
{
 
    static String[] parse(String s){
        
        String ss[]={"","","",""};
        int index=0;
        while(index<s.length() && s.charAt(index)>='A' && s.charAt(index)<='Z'){
            ss[0]+=s.charAt(index++);
        }
         while(index<s.length() && s.charAt(index)>='0' && s.charAt(index)<='9'){
            ss[1]+=s.charAt(index++);
        }
           while(index<s.length() && s.charAt(index)>='A' && s.charAt(index)<='Z'){
            ss[2]+=s.charAt(index++);
        }
         while(index<s.length() && s.charAt(index)>='0' && s.charAt(index)<='9'){
            ss[3]+=s.charAt(index++);
        }
        
        
        return ss;
    }
    
    static String ans1(int x,int y){
        String s="";
        while(x>0){
            s=(char)(((x-1)%26)+'A')+s;
            x=(x-1)/26;
        }
        s+=y;
        return s;
        
    }
    
    static String ans2(String s,int x){
        int idx=0;
       
        int ans=0;
        while(idx<s.length())
        ans=26*ans+(s.charAt(idx++)-'A'+1);
        
        return "R"+x+"C"+ans;
    }
	public static void main(String args[]) throws Exception
	{
		InputReader sc=new InputReader(System.in);		
		PrintWriter w=new PrintWriter(System.out);
			
	int n=sc.nextInt();
        
        while(n>0){
            String s=sc.readString();
           
            String ss[]=parse(s);
            if(ss[0].equals("R") && ss[2].equals("C")){
                System.out.println(ans1(Integer.parseInt(ss[3]),Integer.parseInt(ss[1])));
            }else{
                System.out.println(ans2(ss[0],Integer.parseInt(ss[1])));
            }
            n--;
        }
	}
}



	 class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
		}
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	}
 
