/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	messages = new Post[25];
		size = 0;
    }

    public void add(Post message) {
      if(size==MAX_SIZE) {
		System.out.println("Max size reached");
		return;
	  }
	  messages[size++] = message;
    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
  		 NewsFeed photoFeed = new NewsFeed();

        for(int i=0; i < size; i++){
            if (messages[i].getClass().getName().equals("PhotoPost")){ 
                photoFeed.add(messages[i]); 
            }
        }
        return photoFeed;
  	}

  	public NewsFeed plus(NewsFeed other){
		NewsFeed newFeed = new NewsFeed();

		for(int i = 0; i < size(); i++) {
			newFeed.add(other.messages[i]);
		}
		for(int j = 0; j < size(); j++) {
			newFeed.add(other.messages[j]);
		}

		newFeed.sort();
		return newFeed;
  	}

}
