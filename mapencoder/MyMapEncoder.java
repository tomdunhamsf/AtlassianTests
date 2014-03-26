package mapencoder;

import java.util.Map;

public class MyMapEncoder implements MapEncoder {

	@Override
	public String encode(Map<String, String> map) throws IllegalArgumentException {
		if(map==null){ //multiple exit points, but easy to understand
			return null;
		}else if(map.isEmpty()){
			return "";
		}else{// common case
			String key;
			String value;
			StringBuilder encoding=new StringBuilder();
			for(Map.Entry<String, String> entry : map.entrySet()){
				key=entry.getKey();
				value=entry.getValue();
				if(key.contains("=")||key.contains("&")||value.contains("=")||value.contains("&")){
					throw new IllegalArgumentException("Map key or value contains = or &");
				}else{
					if(encoding.length()>0){
						encoding.append("&");
					}
					encoding.append(key).append("=").append(value);
				}
			}
			return encoding.toString();
		}
	}

}
