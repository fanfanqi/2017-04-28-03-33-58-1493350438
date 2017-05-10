import java.util.HashMap;
public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    	int score=0;
    	String[] arr = bowlingCode.split("|");//分割字符串
    	if(arr.length==12)
    		arr[10]=arr[11];
    	for(int i=0;i<arr.length;i++)//遍历十个格子
    	System.out.println(arr[i]);
    	//计算十个格子的分数
		for(int i=0;i<10;i++){
			String tmp=arr[i];//第i 个格子的标记
			score+=getScore(tmp,i,arr);
		}
        return score;
    }
    public int getScore(String flag,int i,String[] arr){
    	HashMap map = new HashMap<Character,Integer>();
    	map.put('1',1);
    	map.put('2',2);
    	map.put('3',3);
    	map.put('4',4);
    	map.put('5',5);
    	map.put('6',6);
    	map.put('7',7);
    	map.put('8',8);
    	map.put('9',9);
    	map.put('X',10);
    	map.put('-',0);
    	map.put('/',10);
    	//获取flag的长度
    	int size = flag.length();
    	int sco = 0;
    	//size==1 表示X，strike
    	if(size==1){
    		if(arr[i+1].length()==2){//下一格有两个记录
    			if(arr[i+1].charAt(1)!='/'){//下一个记录不含有'/'
    			int first = (int)map.get(arr[i+1].charAt(0));
    			int second = (int)map.get(arr[i+1].charAt(1))+first;
    			sco = 10+(first>second?first:second);//sco=10+second;
    			}else{//下一个记录含有'/'
    			sco=10+10;
    			}
    		}else{//下一格只有一个记录(有一个strike)，还需加上在下一个的第一个记录
    			sco=10+10+(int)map.get(arr[i+2].charAt(0));
    		}
    	}
    	if(size==2){//有两种情况，1有spare,2无spare
    		if(flag.charAt(1)=='/'){//1有spare
    			sco=10+(int)map.get(arr[i+1].charAt(0));
    		}else{//2无spare
    			int first =(int)map.get(arr[i].charAt(0));
    			int second =(int)map.get(arr[i].charAt(1))+first;
    			sco = first>second?first:second;//sco=second;
    		}
    	}
    	return sco;
    }

}
