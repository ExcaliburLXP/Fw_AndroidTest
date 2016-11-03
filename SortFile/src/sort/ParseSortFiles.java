package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 解析文件
 2.排序（java程序）
 有10个文件，需要对文件中的数据进行排序(按歌手拼音顺序)和去掉重复数据，并生成一个文件
 * @author liuxipeng
 *
 */
public class ParseSortFiles {
	
	public static TreeSet<Music> parse(){
		TreeSet<Music> set=new TreeSet<Music>();
		//Set<Music> set=new HashSet<Music>();
		File file=null;
		Music music=null;
		BufferedReader reader=null;
		String tempString=null;
		StringBuffer buffer=null;
		for(int i=0;i<10;i++){
			try{
				
			file=new File("src/"+"test"+i);
			reader=new BufferedReader(new FileReader(file));
			while((tempString=reader.readLine())!=null){
				if(tempString.length()!=0){
				String[] temp=tempString.split(" ");
				buffer=new StringBuffer();
				for(int j=1;j<temp.length;j++){
					buffer.append(temp[j]);
				}
				String song=temp[0];
				String singer=buffer.toString();
				music=new Music(singer, song);
				set.add(music);
				}
			}
		}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
			finally{
				if(reader!=null){
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return set;
	}
}
