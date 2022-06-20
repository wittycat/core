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
		* 归并排序【BM20 数组中的逆序对】
		
			    static Integer count = 0;
			    public static int InversePairs(int [] array) {
			        splitArr(array,0,array.length-1);
			        return count;
			    }
			
			    private   static void splitArr(int[] array, int left, int right) {
			        if (left == right) {
			            return;
			        }
			        int mid = left + (right - left) / 2;
			        splitArr(array, left, mid);
			        splitArr(array, mid+1, right);
			        merge(array, left, mid, right);
			    }
			
			    private static void merge(int[] array, int left, int mid, int right) {
			        int[] arr = new int[right - left + 1];
			        int arrIndex = 0;
			        int i = left;
			        int j = mid + 1;
			        while (i <= mid && j <= right) {
			            if (array[i] < array[j]) {
			                arr[arrIndex] = array[i];
			                i++;
			            } else {
			                arr[arrIndex] = array[j];
			                //理解这句  举例 「1 2 3 4」   「0 5 6 7 」，1大于0，1后面都大于0，到mid ，那么就是mid-i+1
			                count = count + mid - i + 1;
			                j++;
			            }
			            arrIndex++;
			        }
			        while (i <= mid) {
			            arr[arrIndex] = array[i];
			            i++;
			            arrIndex++;
			        }
			        while (j <= right) {
			            arr[arrIndex] = array[j];
			            j++;
			            arrIndex++;
			        }
			
			        for (int k = left; k <= right; k++) {
			            array[k] = arr[k - left];
			        }
			    }
		* 快速排序 【BM47寻找第K大】
			
				public class QuickSort {
					private static void swap(int[] data, int i, int j) {
						int temp = data[i];
						data[i] = data[j];
						data[j] = temp;
					}
				
					private static void subSort(int[] data, int start, int end) {
						if (start < end) {
							int base = data[start];
							int low = start;
							int high = end + 1;
							while (true) {
								while (low < end && data[++low] - base <= 0)
									;
								while (high > start && data[--high] - base >= 0)
									;
								if (low < high) {
									swap(data, low, high);
								} else {
									break;
								}
							}
							swap(data, start, high);
							
							subSort(data, start, high - 1);//递归调用
							subSort(data, high + 1, end);
						}
					}
					public static void quickSort(int[] data){
						subSort(data,0,data.length-1);
					}
				}
	* 场景实例
	  * BM54三数之和
	  		
	  		    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
			        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			        //排序
			        Arrays.sort(num);
			        for (int i = 0; i < num.length - 1; i++) {
			            if (num[i] > 0) {
			                break;
			            }
			            int sum = -num[i];
			            if (keys.contains(sum)) {
			                continue;
			            } else {
			                keys.add(sum);
			            }
			            //在后面的阶段寻找
			            int left = i + 1;
			            int right = num.length - 1;
			            while (left < right) {
			                if (sum == num[left] + num[right]) {
			                    ArrayList<Integer> data = new ArrayList();
			                    data.add(num[i]);
			                    data.add(num[left]);
			                    data.add(num[right]);
			                    res.add(data);
			                    //排除重复的数字
			                    while ((left + 1) < num.length && num[left] == num[left + 1]) {
			                        left++;
			                    }
			                    while ((right - 1) > 0 && num[right] == num[right - 1]) {
			                        right--;
			                    }
			                    left++;
			                    right--;
			                } else if (sum > num[left] + num[right]) {
			                    left++;
			                } else if (sum < num[left] + num[right]) {
			                    right--;
			                }
			            }
			        }
			        return res;
		   		 }
 * 单链表，双链表
 	* 解题思路
 		* 虚头
 		* 提前记录当前节点（指针） 	 
 		* 根据是否能找到下一个节点为null，判断是否有环；如果链表有环，那快慢双指针会在环内循环，因为快指针每次走两步，因此快指针会在环内追到慢指针，二者相遇就代表有环
 		* 双指针
			* 快慢指针（同向）
			* 两端指针
			* 2个指针构成的滑动窗口（计算窗口最大值...）
		* 链表的归并排序：BM12单链表的排序 
 * 栈
   *  解题思路
 		*  2个栈构建一个队列：一个放，一个取（没有了从另外一个放） 
 		*  BM44有效括号序列:
 				
 				public boolean isValid (String s) {
			        if(s==null||s.equals("")){
			            return false;
			        }
			        char[] chars = s.toCharArray();
			        if(chars.length<2){
			            return false;
			        }
			        Stack<Character> stack = new Stack<>();
			        for (int i = 0; i <chars.length ; i++) {
			            if(chars[i]=='('||chars[i]=='['||chars[i]=='{'){
			                stack.push(chars[i]);
			                continue;
			            }else {
			                if(stack.empty()){
			                    return false;
			                }
			                if(chars[i]==')'){
			                   if( stack.pop()!='('){
			                       return false;
			                   }
			                }
			                if(chars[i]==']'){
			                    if( stack.pop()!='['){
			                        return false;
			                    }
			                }
			                if(chars[i]=='}'){
			                    if(stack.pop()!='{'){
			                        return false;
			                    }
			                }
			            }
			        }
			        if(!stack.empty()){
			            return false;
			        }
			        return true;
			    }
    
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
     * 构建 ：堆总是一棵完全二叉树
     
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
   * 一些基本操作
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
		* 获取树的深度（递归使用）；方法二，层序遍历，看有多少层
		
				   public int maxDepth (TreeNode root) {
				        if(root==null){
				            return 0;
				        }
				        int max = Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
				        return max;
				    }
		* BM29二叉树中和为某一值的路径一
		
				 private boolean exist(TreeNode root, int sum) {
			        if (root == null) {
			            return false;
			        }
			        //终止条件
			        if (root.left == null && root.right == null && (root.val - sum) == 0) {
			            return true;
			        }
			        //迭代过程
			        return exist(root.left, sum - root.val) || exist(root.right, sum - root.val);
			    }
		* BM31对称的二叉树
			
				   private boolean judge(TreeNode left, TreeNode right) {
				        if (left == null && right == null) {
				            return true;
				        }
				        //不相等条件
				        if (left == null || right == null || right.val != left.val) {
				            return false;
				        }
				        //互相相等
				        return judge(left.left, right.right) && judge(left.right, right.left);
				    }
		* BM32合并二叉树
				
				   private TreeNode mergeTree(TreeNode t1, TreeNode t2) {
				        if(t1==null){
				            return t2;
				        }
				        if(t2==null){
				            return t1;
				        }
				
				        int sum = t1.val+t2.val;
				        TreeNode root = new TreeNode(sum);
				
				        TreeNode left = mergeTree(t1.left, t2.left);
				        TreeNode right = mergeTree(t1.right, t2.right);
				        root.left = left;
				        root.right = right;
				        return root;
				    }
		* BM33二叉树的镜像
			
				  private TreeNode createMirror(TreeNode root) {
			        if(root==null){
			            return null;
			        }
			        TreeNode treeNode = new  TreeNode(root.val);
			        treeNode.left=createMirror(root.right);
			        treeNode.right=createMirror(root.left);
			        return treeNode;
			    }
		* xxxx
		* xxxx
   	* 场景分析
   		* 二叉树先当做一个最小单元写出逻辑，然后递归
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
	* 有的想不到巧妙的方法，可以试试暴力破解。（2层 ，3层循环）
* 递归回溯
	* 一维数字dfs【BM55没有重复项数字的全排列】
		
			   public static ArrayList<ArrayList<Integer>> permute(int[] num) {
			        ArrayList<ArrayList<Integer>> res = new ArrayList();
			        ArrayList<Integer> temp = new ArrayList();
			        int[] visit = new int[num.length];
			        dfs(num, res, temp, visit);
			        return res;
			    }
			    private static void dfs(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] visit) {
			        if (temp.size() == num.length) {
			            res.add(new ArrayList<>(temp));
			        } else {
			            for (int j = 0; j < num.length; j++) {
			                if (visit[j] == 1) {
			                    continue;
			                }
			                temp.add(num[j]);
			                visit[j] = 1;
			                dfs(num, res, temp, visit);
			                visit[j] = 0;
			                temp.remove(temp.size() - 1);
			            }
			        }
			    }
   * 一维有重复数字dfs【BM56有重复项数字的全排列】，排序，跳过
   	
   			  public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		        Arrays.sort(num);
		        ArrayList<ArrayList<Integer>> res = new ArrayList();
		        ArrayList<Integer> temp = new ArrayList();
		        int[] visit = new int[num.length];
		        dfs(num, res, temp, visit);
		        return res;
		    }
		    private static void dfs(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] visit) {
		        if (temp.size() == num.length) {
		            res.add(new ArrayList<>(temp));
		        } else {
		            for (int j = 0; j < num.length; j++) {
		                if (visit[j] == 1) {
		                    continue;
		                }
		                ////当前的元素num[i]与同一层的前一个元素num[i-1]相同且num[i-1]已经用过了
		                if (j > 0 && num[j] == num[j - 1] && visit[j - 1] == 0) {
		                    continue;
		                }
		                temp.add(num[j]);
		                visit[j] = 1;
		                dfs(num, res, temp, visit);
		                visit[j] = 0;
		                temp.remove(temp.size() - 1);
		            }
		        }
		    }
   * 字符串dfs
   	
	   		   public static ArrayList<String> Permutation(String str) {
			        HashSet<String> set = new HashSet<>();
			        char[] chars = str.toCharArray();
			        int[] visit = new int[chars.length];
			        dfs(chars, visit, "", set);
			        return new ArrayList<>(set);
			    }
			    private static void dfs(char[] chars, int[] visit, String res, HashSet<String> set) {
			        if (res.length() == chars.length) {
			            set.add(res);
			            return;
			        }
			        for (int i = 0; i < chars.length; i++) {
			            if (visit[i] == 1) {
			                continue;
			            }
			            visit[i] = 1;
			            char addChar = chars[i];
			            dfs(chars, visit, res + addChar, set);
			            visit[i] = 0;
			        }
			    }
   * BM60括号生成 ：特殊的字符dfs
   		
	   		    public static ArrayList<String> generateParenthesis (int n) {
			        ArrayList<String> list = new ArrayList<>();
			        dfs("", 0, 0, n, list);
			        return list;
			    }
			    private static void dfs(String res, int left, int right, int n, ArrayList<String> list) {
			        if (left == n && right == n) {
			            list.add(res);
			            return;
			        }
			        if (left < n) {
			            dfs(res + "(", left + 1, right, n, list);
			        }
			        if (right < left) {
			            dfs(res + ")", left, right + 1, n, list);
			        }
			    }
   * 二维数组的dfs【BM61矩阵最长递增路径】【BM59N皇后问题】
   		
		   		public class BM59N皇后问题 {
				    private static int all = 0;
				    public static int Nqueen(int n) {
				        int[][] arr = new int[n][n];
				        dfs(arr, 0);
				        return all;
				    }
				    /**
				     * @param arr
				     * @param i   第几行
				     */
				    private static void dfs(int[][] arr, int i) {
				        int n = arr.length;
				        if (i == n) {
				            all++;
				            return;
				        }
				        for (int j = 0; j < n; j++) {
				            if (arr[i][j] == 0 && verify(i, j, arr)) {
				                arr[i][j] = 1;
				                dfs(arr, i + 1);
				                arr[i][j] = 0;
				            }
				        }
				    }
				    private static boolean verify(int i, int j, int[][] arr) {
				        int n = arr.length;
				        //行
				        for (int row = 0; row < n; row++) {
				            if (arr[i][row] == 1) {
				                return false;
				            }
				        }
				        //列
				        for (int col = 0; col < n; col++) {
				            if (arr[col][j] == 1) {
				                return false;
				            }
				        }
				        //左上
				        for (int i1 = i, j1 = j; i1 >= 0 && j1 >= 0; ) {
				            if (arr[i1][j1] == 1) {
				                return false;
				            }
				            i1--;
				            j1--;
				        }
				        //左下
				        for (int i1 = i, j1 = j; i1 < n && j1 < n; ) {
				            if (arr[i1][j1] == 1) {
				                return false;
				            }
				            i1++;
				            j1++;
				        }
				        //右上
				        for (int i1 = i, j1 = j; i1 >=0 && j1 < n; ) {
				            if (arr[i1][j1] == 1) {
				                return false;
				            }
				            i1--;
				            j1++;
				        }
				        //右下
				        for (int i1 = i, j1 = j; i1 < n && j1 >= 0; ) {
				            if (arr[i1][j1] == 1) {
				                return false;
				            }
				            i1++;
				            j1--;
				        }
				        return true;
				    }
				    public static void main(String[] args) {
				        System.out.println(Nqueen(8));
				    }
			}
     
* 动态规划
* 贪心
* 著名算法
	* 数据结构--最小生成树详解 普里姆算法—Prim算法 https://blog.csdn.net/qq_35644234/article/details/59106779
 	* 最短路径问题---Floyd算法详解  https://blog.csdn.net/qq_35644234/article/details/60875818

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 