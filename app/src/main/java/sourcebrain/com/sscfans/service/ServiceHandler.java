package sourcebrain.com.sscfans.service;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ServiceHandler {

    static String response = null;
    public final static String GET = "GET";
    public final static String POST = "POST";
    final static int connectionTimeout = 15000;
    final static int readTimeout = 10000;

    public ServiceHandler() {

    }

    /**
     * Make service call
     */
    public String makeServiceCall(String url,String method) throws IOException {
        InputStream is = null;
        String contentAsString = "";

        try {
            URL serverUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setReadTimeout(readTimeout);
            conn.setConnectTimeout(connectionTimeout);
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.connect();

            is = conn.getInputStream();
            contentAsString = readStream(is);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return contentAsString;
    }

    
    /*
     * Read inputstream to get the response string
     */
    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

}