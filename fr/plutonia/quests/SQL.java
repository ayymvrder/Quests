package fr.plutonia.quests;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;

/**
 * 
 * @author SkyDiams
 * @since 4 juin 2017:22:26:39
 * @version 1.1
 * This class is make 4 juin 2017
 * This api is public but is is under Apache License
 * This api is the property of @author Mathieu Dejoie
 *
 */
public class SQL {

	private SQLBase sqlBase;
	
	public SQL() { }
	
	/**
	 * 
	 * @param asb
	 */
	public SQL(SQLBase asb) {
		this.sqlBase = asb;
	}
	
	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:26:44
	 * @return SQLBase
	 * @return
	 */
	public SQLBase getSqlBase() {
		return sqlBase;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:26:47
	 * @return void
	 * @param sqlBase
	 */
	public void setSqlBase(SQLBase sqlBase) {
		this.sqlBase = sqlBase;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:26:49
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getObject(java.lang.String, java.lang.Object[])
	 */
	
	public Object getObject(String name, Object... args) {
		if(args.length < 3) {
			return null;
		}
		Object obj = null;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return obj;
			}
			obj = rs.getObject(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:26:53
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getString(java.lang.String, java.lang.Object[])
	 */
	
	public String getString(String name, Object... args) {
		if(args.length < 3) {
			return "";
		}
		String st = "";
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return st;
			}
			st = rs.getString(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:26:57
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getInt(java.lang.String, java.lang.Object[])
	 */
	
	public int getInt(String name, Object... args) {
		if(args.length < 3) {
			return 0;
		}
		int i = 0;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return i;
			}
			i = rs.getInt(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:00
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getFloat(java.lang.String, java.lang.Object[])
	 */
	
	public float getFloat(String name, Object... args) {
		if(args.length < 3) {
			return 0;
		}
		float i = 0;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return i;
			}
			i = rs.getFloat(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:04
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getBoolean(java.lang.String, java.lang.Object[])
	 */
	
	public boolean getBoolean(String name, Object... args) {
		if(args.length < 3) {
			return false;
		}
		boolean i = false;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return i;
			}
			i = rs.getBoolean(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:07
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getByte(java.lang.String, java.lang.Object[])
	 */
	
	public byte getByte(String name, Object... args) {
		if(args.length < 3) {
			return 0;
		}
		byte var = 0;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getByte(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:10
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getShort(java.lang.String, java.lang.Object[])
	 */
	
	public short getShort(String name, Object... args) {
		if(args.length < 3) {
			return 0;
		}
		short var = 0;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getShort(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:13
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getLong(java.lang.String, java.lang.Object[])
	 */
	
	public long getLong(String name, Object... args) {
		if(args.length < 3) {
			return 0;
		}
		long var = 0;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getLong(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:16
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getDouble(java.lang.String, java.lang.Object[])
	 */
	
	public double getDouble(String name, Object... args) {
		if(args.length < 3) {
			return 0;
		}
		double var = 0;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getDouble(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:19
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getBytes(java.lang.String, java.lang.Object[])
	 */
	
	public byte[] getBytes(String name, Object... args) {
		if(args.length < 3) {
			return new byte[0];
		}
		byte[] var = new byte[0];
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getBytes(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:22
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getDate(java.lang.String, java.lang.Object[])
	 */
	
	public Date getDate(String name, Object... args) {
		if(args.length < 3) {
			return new Date(new java.util.Date().getTime());
		}
		Date var = new Date(new java.util.Date().getTime());
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getDate(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:25
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getTime(java.lang.String, java.lang.Object[])
	 */
	
	public Time getTime(String name, Object... args) {
		if(args.length < 3) {
			return new Time(0);
		}
		Time var = new Time(0);
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getTime(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:27
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getTimestamp(java.lang.String, java.lang.Object[])
	 */
	
	public Timestamp getTimestamp(String name, Object... args) {
		if(args.length < 3) {
			return new Timestamp(0);
		}
		Timestamp var = new Timestamp(0);
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getTimestamp(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:30
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getAsciiStream(java.lang.String, java.lang.Object[])
	 */
	
	public InputStream getAsciiStream(String name, Object... args) {
		if(args.length < 3) {
			return null;
		}
		InputStream var = null;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getAsciiStream(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:33
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getUnicodeStream(java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("deprecation")
	
	public InputStream getUnicodeStream(String name, Object... args) {
		if(args.length < 3) {
			return null;
		}
		InputStream var = null;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getUnicodeStream(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:36
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getBigDecimal(java.lang.String, java.lang.Object[])
	 */
	
	public BigDecimal getBigDecimal(String name, Object... args) {
		if(args.length < 3) {
			return null;
		}
		BigDecimal var = new BigDecimal(0);
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getBigDecimal(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:38
	 * @param name
	 * @param arg1
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getObject(java.lang.String, java.util.Map, java.lang.Object[])
	 */
	
	public Object getObject(String name, Map<String, Class<?>> arg1, Object... args) {
		if(args.length < 3) {
			return null;
		}
		Object var = null;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getObject(column, arg1);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:42
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getArray(java.lang.String, java.lang.Object[])
	 */
	
	public Array getArray(String name, Object... args) {
		if(args.length < 3) {
			return null;
		}
		Array var = null;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getArray(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:45
	 * @param name
	 * @param args
	 * @return
	 * @see com.skydiams.askia.base.AskiaStorage#getURL(java.lang.String, java.lang.Object[])
	 */
	
	public URL getURL(String name, Object... args) {
		if(args.length < 3) {
			return null;
		}
		URL var = null;
		String tab = args[0].toString();
		String reference = args[1].toString();
		String column = args[2].toString();
		try {
			PreparedStatement preparedStatement = sqlBase.getConnection().prepareStatement("SELECT "+column+" FROM " + tab + " WHERE "+reference+" = ?");
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(!rs.next()) {
				return var;
			}
			var = rs.getURL(column);
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return var;
	}
	
}
