package lossychecker;

import java.io.UnsupportedEncodingException;
import java.nio.*;
import java.nio.charset.*;
public class MyLossyChecker implements LossyChecker {

	@Override
	public boolean isLossy(String s, String encoding)
			throws UnsupportedEncodingException {
		boolean lossy=false;
		Charset cs=null;
		try{
			cs=Charset.forName(encoding);
		}catch(Exception e){
			throw new UnsupportedEncodingException(e.getMessage());
		}
		CharsetEncoder encoder = cs.newEncoder();
		encoder.onUnmappableCharacter(CodingErrorAction.REPORT);
		lossy=!encoder.canEncode(s);
		return lossy;
	}

}
