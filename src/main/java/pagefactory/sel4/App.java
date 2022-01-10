package pagefactory.sel4;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String header="{Upgrade-Insecure-Requests=1, User-Agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) HeadlessChrome/96.0.4664.110 Safari/537.36}";
        
        System.out.println(header.substring(header.indexOf("User-Agent")+11, header.length()-1));
        		
    }
}