package persistence;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

//classe random per pulire il consent manager

// tutte le eccezioni sono state catturate perch� boh

// manca in toto il provider

public class SecurityManager implements ISecurityManager {

	private KeyPair keyPair;

	private final String keyAlgorithm = "DSA";
	private final String randomAlgorithm = "SHA1PRNG";
	private final String provider = "SUN";
	private final String signatureAlgorithm = "SHA1withDSA";

	public SecurityManager() {
		try {
			this.keyPair = generateKeys(keyAlgorithm, randomAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private KeyPair generateKeys(String keyAlgorithm, String randomAlgorithm) throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(keyAlgorithm);
		SecureRandom random = null;
		try {
			random = SecureRandom.getInstance(randomAlgorithm, provider);
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1024 e gli altri dati vanno bene?
		keyPairGen.initialize(1024, random);
		return keyPairGen.generateKeyPair();
	}

	public byte[] sign(byte[] toSign) {

		// questo algoritmo � solo uno scheletro
		// manca la lettura da file
		// l'update dei bytes non ha molto senso fatto cos�

		Signature dsa = null;
		try {
			dsa = Signature.getInstance(signatureAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrivateKey privKey = keyPair.getPrivate();
		try {
			dsa.initSign(privKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte realSig[] = null;
		try {
			dsa.update(toSign);
			realSig = dsa.sign();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return realSig;
	}

	public boolean verify(PublicKey pubKey, byte[] toUpdate, byte[] toVerify) {

		// questo algoritmo � solo uno scheletro
		// manca la lettura da file
		// l'update dei bytes non ha molto senso fatto cos�

		Signature dsa = null;
		try {
			dsa = Signature.getInstance(signatureAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean result = false;
		try {
			dsa.initVerify(pubKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dsa.update(toUpdate);
			result = dsa.verify(toVerify);
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	@Override
	public PublicKey getPublicKey() {
		return this.keyPair.getPublic();
	}
}