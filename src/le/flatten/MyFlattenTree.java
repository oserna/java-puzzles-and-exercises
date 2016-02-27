package le.flatten;

import java.util.ArrayList;
import java.util.List;

public class MyFlattenTree<T> implements FlattenTree<T> {
	
  /**
   * A kind of visitor function trying to go down to the left until is possible. Once we
   * have reached the deepest level going up and turning to the right when is possible
   * 
   */
  public List<T> flattenInOrder(Tree<T> tree) {
	  
		Either<T, Triple<Tree<T>>> either = tree.get();

		if(either.isLeft()){
			return either.ifLeft(new Function<T,List<T>>(){
									@Override
									public List<T> apply(final T p) {
										return new ArrayList<T>(){{add(p);}};
									}});
		}else{
			return either.ifRight(new Function<Triple<Tree<T>>,List<T>>(){
									@Override
									public List<T> apply(final Triple<Tree<T>> p) {
										return new ArrayList<T>(){{
											addAll(flattenInOrder(p.left()));
											addAll(flattenInOrder(p.middle()));
											addAll(flattenInOrder(p.right()));
										}};
									}});
		}
  }
  
}
