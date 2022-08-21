class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> table = new ArrayList<>();
        
        HashMap<String,HashMap<Integer,Integer>> map = new HashMap<>();
        
        TreeSet<Integer> tables = new TreeSet<>();
        
        TreeSet<String> items = new TreeSet<>();
        
        for(List<String> order:orders)
        {
            int tableNumber = Integer.parseInt(order.get(1));
            String item = order.get(2);
            
            items.add(item);
            
            tables.add(tableNumber);
            
            if(map.containsKey(item))
            {
                HashMap<Integer,Integer> m = map.get(item);
                m.put(tableNumber,m.getOrDefault(tableNumber,0)+1);
                map.put(item,m);
            }
            else
            {
                HashMap<Integer,Integer> m = new HashMap<>();
                m.put(tableNumber,1);
                map.put(item,m);
            }
        }
        
        List<String> firstRow = new ArrayList<>();
        
        firstRow.add("Table");
        
        for(String s:items)
        {
            firstRow.add(s);
        }
        
        table.add(firstRow);
        
        items = null;
        
        for(Integer i:tables)
        {
            List<String> row = new ArrayList<>();
            
            row.add(String.valueOf(i));
            
            int m = firstRow.size();
            
            for(int j=1;j<m;j++)
            {
                String item = firstRow.get(j);
                
                if(map.get(item).containsKey(i))
                {
                    int number = map.get(item).get(i);
                    
                    row.add(String.valueOf(number));
                }
                else{
                    row.add("0");
                }
            }
            
            table.add(row);
        }
        
        return table;
        
    }
}
