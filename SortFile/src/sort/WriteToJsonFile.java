package sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import net.sf.json.JSONArray;
import net.sf.json.util.NewBeanInstanceStrategy;


/**
 * 3生成json格式文件
 * @author liuxipeng
 * 
 * 使用json-lib-2.2.3-jdk15.jar必要也要导入它的依赖包：
ezmorph-1.0.6.jar 
commons-lang 2.4 
commons-beanutils 1.7.0 
commons-collections 3.2 
commons-logging 1.1.1
 *
 */
public class WriteToJsonFile {

	public static File WriteToJsonFile(){
	TreeSet<Music> set=ParseSortFiles.parse();
	File file=null;
	List<Music> list=new ArrayList<Music>();
	
		for(Music m:set){
			list.add(m);
		}
		
	String  jsonString=JSONArray.fromObject(list).toString();
	System.out.println(jsonString);
	try {
	    File f = new File("src/json");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(jsonString);
        bw.close();
        fw.close();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	return file;
	}

}
