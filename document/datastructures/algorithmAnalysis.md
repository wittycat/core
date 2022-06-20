#### 1.基础库常用方法类
 * 数组指定范围排序 java.util.Arrays#sort(int[], int, int)
 * 数组排序 java.util.Arrays#sort(long[])
 * 二分法搜索 java.util.Arrays#binarySearch(int[], int)
 	* 必须在进行此调用之前对数组进行排序（通过 sort(int[]) 方法）。
 	* 如果没有对数组进行排序，则结果是不确定的。如果数组包含多个带有指定值的元素，则无法保证找到的是哪一个。 
 
#### 2.数据结构与算法以及解题思路
 * 数组	
	*  查找
	 	* 链式查找：链表或者数组一个个比较查找
	 	* 二分查找
			* 一维数组，获取 最小（l），最大角标（r）去取中间角标m值，大于r=m-1，否则l=m+1。不断缩小某一边范围
			* 二维数组，取左下角值，大y移动（y--），小了x移动（x++），找不到不存在 。 
	*  排序
		* 归并排序，【BM20 数组中的逆序对】
		* 快速排序
 * 单链表，双链表
 	* 解题思路
 		* 虚头
 		* 提前记录当前节点（指针） 	 
 		* 根据是否能找到下一个节点为null，判断是否有环；如果链表有环，那快慢双指针会在环内循环，因为快指针每次走两步，因此快指针会在环内追到慢指针，二者相遇就代表有环
 		* 指针
			* 快慢指针（同向）
			* 两端指针
		* 链表的归并排序：BM12单链表的排序 
 * 栈
   *  解题思路
 		*  2个栈构建一个队列：一个放，一个取（没有了从另外一个放） 
 * 队列
 	* 数据结构 
 	
		 	    //将元素插入队列尾部，方法在添加失败(比如队列已满)时，不会抛出异常，值会返回false
		 	    
		       boolean offer(E e);
		       
		       //将队首的元素删除，队列为空则返回null
		       
		       E poll();
		       
		       //获取队首元素，但不移除，队列为空则返回null
		       
		       E peek();
		 
		       //将元素插入队列尾部，方法在添加失败(比如队列已满)时会报 一些运行时错误.
		       
		       boolean add(E e);
		       
		       //将队首的元素删除，队列为空则抛出异常
		       
		       E remove();
		       
		       //获取队首元素，但不移除，队列为空则抛出异常
		       
		       E element(); 	
       
 * 堆
 
       	      //⼩顶堆，默认容量为11
       	      PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
       	      //⼤顶堆
              PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){
              @Override
              public int compare(Integer i1,Integer i2){
                       return i2-i1;
                   }
              });
    
* 哈希
* 二叉树
	* 类别
		*  满二叉树（最标准，节点最多） 	 	
		*  完全二叉树（倒数第一层左到右连续，倒数第二层左到右连续）满二叉树肯定是完全二叉树，而完全二叉树不一定是满二叉树,堆总是一棵完全二叉树
		*  二叉搜索树(BST二叉排序树) ：中序遍历后为一个，数组小到大
		*  平衡二叉树（AVL）：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
		*  线索二叉
   * 操作
   		*	前序遍历：根左右 （dfs）
   		   
			   	    private void getData(TreeNode root, List<Integer> list) {
				        if(root==null){
				            return;
				        }
				        list.add(root.val);
				
				        if(root.left!=null){
				            getData(root.left,list);
				        }
				
				        if(root.right!=null){
				            getData(root.right,list);
				        }
			        }
   		* 	中序遍历：左根右 （dfs）	 	
   		
	   			    private void getData(TreeNode root, List<Integer> list) {
				        if(root==null){
				            return;
				        }
				        if(root.left!=null){
				            getData(root.left,list);
				        }
				        list.add(root.val);
				
				        if(root.right!=null){
				            getData(root.right,list);
				        }
				    }
   		*  后续遍历：左右根（dfs）
   					
				   private void getData(TreeNode root, List<Integer> list) {
				        if(root==null){
				            return;
				        }
				
				        if(root.left!=null){
				            getData(root.left,list);
				        }
				        if(root.right!=null){
				            getData(root.right,list);
				        }
				        list.add(root.val);
				    }
		* 层序遍历（bfs）
		
				public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
			        ArrayList<ArrayList<Integer>> total = new ArrayList();
			        if(root==null){
			            return total;
			        }
			        Deque<TreeNode> arrayDeque = new ArrayDeque();
			        arrayDeque.add(root);
			        while (!arrayDeque.isEmpty()){
			            int size = arrayDeque.size();
			            ArrayList<Integer> row = new ArrayList();
			            for (int i = 0; i < size; i++) {
			                TreeNode poll = arrayDeque.poll();
			                row.add(poll.val);
			                if(poll.left!=null){
			                    arrayDeque.add(poll.left);
			                }
			                if(poll.right!=null){
			                    arrayDeque.add(poll.right);
			                }
			            }
			            total.add(row);
			        }
			        return total;
			    }
   	* 场景分析
   	   * 三种遍历：（都属于深度遍历）
   		* 前序遍历+中序遍历的数组:重构二叉树
   		* 层级遍历：（广度遍历）
   			* 序列化二叉树
   		* 把整体二叉树看待成一个小二叉树，然后使用递归可以解决：
   		* 递归不要在局部创建集合（有返回值），从最外层传入（无返回值）
   		* 如果不使用结构不必要保存TreeNode，直接保存值TreeNode.val就行
   		* ArrayList有时更优 LinkList 
 	 
#### 3.算法场景
* 实战心得
	* 对于大数，按照字符串形式相加。（可以先按位数少的使用0补齐）
* 动态规划
* 递归回溯
* 贪心
* 著名算法
	* 数据结构--最小生成树详解 普里姆算法—Prim算法 https://blog.csdn.net/qq_35644234/article/details/59106779
 	* 最短路径问题---Floyd算法详解  https://blog.csdn.net/qq_35644234/article/details/60875818

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 