package com.solvd.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This sample shows how use Crypto in tests.
 *
 * @author qpsdemo
 */
public class CryptoSampleTest implements IAbstractTest {

    @Test
    public void testPlaceholdersWithEncryptionTestData() {
        Assert.assertEquals(R.TESTDATA.get("test_credentials"), "test@gmail.com/EncryptMe");
    }

    @Test
    public void testEncryption() {
        Assert.assertEquals(R.CONFIG.get("password"), "EncryptMe");
    }

    @Test
    public void testPlaceholdersWithEncryption() {
        Assert.assertEquals(R.CONFIG.get("credentials"), "test@gmail.com/EncryptMe");
    }

}
