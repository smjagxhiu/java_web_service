package sjagxhiu.DbConn.jaxb;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Timestamp> {

	@Override
	public String marshal(Timestamp t) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(t.getTime());
		return df.format(date);
	}

	@Override
	public Timestamp unmarshal(String s) throws Exception {
		try {
			//System.out.println("------------------------------------");
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date date;		
				date = df.parse(s);
				return new Timestamp(date.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new Timestamp(new Date().getTime());
	}

}
