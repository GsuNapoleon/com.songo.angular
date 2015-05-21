/**
 * 
 */
package com.songo.angular.jdbc;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>decription:</p>
 * <p>date:2014年11月7日 上午9:37:42</p>
 * @author gsu·napoleon
 */
public class ChannelDao {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年11月7日 上午9:37:42</p>
	 * @author gsu·napoleon
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		ChannelDao dao = new ChannelDao();
//		List<Channel> childrens = dao.getChannelChildrens(5560);
//		System.out.println(childrens);
//		
//		System.out.println(dao.makeInCase(dao.getIds(childrens)));
//		System.out.println(dao.getThreeLevelChildrens(dao.getIds(childrens)));
		List<Integer> allChildrens = dao.getAllChildrens(0, 5290); 
		System.out.println(allChildrens);
//		System.out.println(dao.filter(dao.getIds(childrens), allChildrens));
//		System.out.println(dao.getAllChildrens(0, 5290));
	}
	
	private List<Integer> getThreeLevelChildrens(List<Integer> twoLevelChildrens) {
		
		List<Integer> results = new ArrayList<Integer>();
		
		for (Integer parentId : twoLevelChildrens) {
			List<Integer> threeLevelChildrens = getIds(getChannelChildrens(parentId));
			results.addAll(threeLevelChildrens);		
		}
		return results;
	}
	
	private List<Integer> filter(List<Integer> srcLists, List<Integer> targetLists) {
		for (Integer src : srcLists) {
			for (Iterator<Integer> iter = targetLists.iterator(); iter.hasNext(); ) {
				Integer target = iter.next();
				if (src.equals(target)) {
					iter.remove();
				}
			}
		}
		return targetLists;
	}
	
	private List<Integer> getIds(List<Channel> channels) {
		List<Integer> childrenIds = new ArrayList<Integer>();
		for (Channel channel : channels) {
			childrenIds.add(channel.getId());
		}
		return childrenIds;
	}
	
	public Connection getConnection(String url, String user, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	}
	
	public List<Channel> getChannelChildrens(int parentId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection("jdbc:mysql://192.168.75.99:3306/cnt_lady"
					+ "?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=GBK", 
					"cnt_it", "cnt_it");
			ps = conn.prepareStatement(" select id, parent_id, rank, name "
					+ "from cnt_channel where parent_id=" + parentId + " and `status` = 0");
			rs = ps.executeQuery();
			List<Channel> channels = new ArrayList<Channel>();
			while (rs.next()) {
				Channel channel = new Channel(rs.getInt("id"), rs.getInt("parent_id"), 
						rs.getInt("rank"), rs.getString("name"));
				channels.add(channel);
			}
			return channels;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				
			}
		}
	}

	public List<Integer> getAllChildrens(int sid, int cid) {
        List<Integer> childrens = getIds(getChannelChildrens(cid));
        List<Integer> results = new ArrayList<Integer>();
        while (childrens != null && childrens.size() > 0) {
            results.addAll(childrens);
            List<Integer> leafList = new ArrayList<Integer>();
            for (int childId : childrens) {
                List<Integer> tempChildrens = getIds(getChannelChildrens(childId));
                if (tempChildrens != null && tempChildrens.size() > 0) {
                    leafList.addAll(tempChildrens);
                }
            }
            childrens = leafList;
        }
        return results;
    }
	
	private String makeInCase(List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
		int size = list.size();
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		for (int i = 0; i < list.size(); i++) {
			builder.append(list.get(i));
			if (i != size - 1) {
				builder.append(",");
			}
		}
		builder.append(")");
		return builder.toString();
	}
	
	public void orm(ResultSet rs, Channel channel) throws SQLException {
		List<Channel> channels = new ArrayList<Channel>();
		ResultSetMetaData metaData = rs.getMetaData();
		int columns = metaData.getColumnCount();
		for (int i = 1; i <= columns; i ++) {
			System.out.println(metaData.getColumnName(i));
			System.out.println(metaData.getColumnType(i));
			System.out.println(metaData.getColumnTypeName(i));
			Channel chl = new Channel();
			List<String> setMethodNames = getSetMethodNames(Channel.class);
			String columnName = "SET" +  metaData.getColumnLabel(i).toUpperCase();
			if (hasExists(columnName, setMethodNames)) {
				
			}
		}
	}
	
	private boolean hasExists(String columnName, List<String> setMethodNames) {
		boolean hasExists = false;
		for (String name : setMethodNames) {
			if (columnName.equals(name)) {
				hasExists = true;
				break;
			}
		}
		return hasExists;
	}
	
	public List<String> getSetMethodNames(Class<Channel> clazz) {
		Method[] methods = clazz.getClass().getMethods();
		List<String> setMethodNames = new ArrayList<String>();
		for (Method method : methods) {
			if (method != null && method.getName().startsWith("set")) {
				setMethodNames.add(method.getName().toUpperCase());
			}
		}
		return setMethodNames;
	}
	
}

