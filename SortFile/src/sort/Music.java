package sort;

/**
 * bean数据
 * @author liuxipeng
 * @param <T>
 *
 */
public class Music implements Comparable{
	
	private String singer;
	private String song;
	
	public Music(String singer,String song){
		this.singer=singer;
		this.song=song;
		
	}
	
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return "Music [singer=" + singer + ", song=" + song + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.singer.compareTo(((Music)o).getSinger());
	}

	
	
	
	
	
}
