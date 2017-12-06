package org.laidu.commom.util.encryption;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
@Slf4j
class DESedeEncryptionUtilTest {

    private String key;
    private String ivp;
    private String palaintext;
    private String cryptograph;

    @BeforeEach
    void setUp() {
        key = "5O0ItwSgCtrrsuV9C2fRJWDBh2FNGItJ";
        ivp = "00000000000000000000000000000000";
        palaintext = "{\"f\":\"loginV3\",\"passport\":\"WiT1Q9UXYZMDAKSstQTlAoeW\",\"phone\":\"13241847378\",\"code\":\"\",\"cv\":\"and1.0.0\\/babaqianbao\",\"app\":\"爸爸钱包\",\"sub_app\":\"爸爸钱包_android\",\"phone_token\":\"\",\"password\":\"q11111111\",\"new_password\":\"\",\"ov\":\"and23\",\"place\":\"xiaomi\"}";
        cryptograph = "5LzbdFzcgXpHYzP%2FMtHpKpqeujNAr7nn05HWALGjudJedauho0G8HRXmgPL9h62PvciQ2NhiQ%2Fj5PPknyP5PYeklspNa3iV5C9hm1%2FGauWR5nNmNfAjkSNPOe9oCK3ao9kiYlPZwJ%2Bggxu6sh0esNDJpIB14WjCOL8C%2BDZuL%2BlyPJqNNLbtzYeOFSdIdV7fe9vhWarVmGlGo92ATTV48vdNrxujOfhyrDBD9ks5pmY%2FwRs0RynrmCTEqbO4iECzTSahRtASv186LflijzlsTndK4aQuAOi4Dy%2B3ZkP04fb%2BVeO0h6vKVIECzkS%2FvmyVXIChsSvHesFnVeg5W4axUhnvGICO4xwM3H1t5lxUnnAo%3D";
    }

    @Test
    void encrypt() {
    }

    @Test
    void decrypt() {
    }

}