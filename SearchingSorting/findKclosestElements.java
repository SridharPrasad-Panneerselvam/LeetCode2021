// https://leetcode.com/problems/find-k-closest-elements/

class Solution
{
    static int searchMid(int [] arr,int left,int right,int x)
    {
        int mid=0;
        while(left <= right)
        {
        mid=(left+right)/2;
        if(x == arr[mid])
        {
           return mid;  
        }
        else if( x < arr[mid])
        {
            right=mid - 1;
        }
        else
        {
           left = mid + 1; 
        }
        }
        return mid;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        List<Integer> list = new ArrayList<>();
         int left = 0, right = arr.length - 1;
          int data = searchMid(arr,left,right,x);  
          int a=data-1;
          int b=data;
         while(list.size() < k)
         {
          if( a >= 0 && b < arr.length)
          {
             if( Math.abs(arr[a] - x) > Math.abs(arr[b] - x)) 
             {
                list.add( arr[b]);
                b++;
             }
              else 
             {  
                list.add( arr[a]);
                a--;
            
              }
          }
          else if( a < 0)
          {
              list.add( arr[b]);
                b++; 
          }
          else
          {
              list.add( arr[a]);
               a--;     
           }
        }
        Collections.sort(list);   
         return list;
    }
}