package sjagxhiu.DbConn.jackson;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateDeserilizer extends JsonDeserializer<Timestamp> {

	@Override
	public Timestamp deserialize(JsonParser jp, DeserializationContext cn)
			throws IOException, JsonProcessingException {
		try {
		String dateStr = jp.getText();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date;		
			date = df.parse(dateStr);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
