package net.xtion.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private OSSClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClientConfiguration conf = new ClientConfiguration();

        //访问地址
        String endpoint = "";

        client = new OSSClient(this, endpoint, new OSSCredentialProvider() {
            @Override
            public OSSFederationToken getFederationToken() throws ClientException {
                //认证数据
                return new OSSFederationToken("", "" , "" ,"");
            }
        }, conf);

        String bucket = ""; //
        String objectKey = ""; //
        byte[] fileByte = "测试内容".getBytes(StandardCharsets.UTF_8);

        final PutObjectRequest put = new PutObjectRequest(bucket, objectKey, fileByte);

        Thread thred = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PutObjectResult result = client.putObject(put);
                    Log.i("","");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thred.start();
    }
}
