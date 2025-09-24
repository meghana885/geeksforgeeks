class SpecialQueue {
    Deque<List<Integer>> q;
    public SpecialQueue() {
        q = new ArrayDeque<>();
    }
    // element , max , min.
    public void enqueue(int x) {
        List<Integer> list = new ArrayList<>();
        if(q.size() == 0)
        {
            list.add(x); // element
            list.add(x); // max
            list.add(x); // min
        }
        else
        {
            int maxIntBoth = Math.max(x, q.peekLast().get(1));
            int minInBoth = Math.min(x, q.peekLast().get(2));
            list.add(x);
            list.add(maxIntBoth);
            list.add(minInBoth);
        }
        q.add(list);
    }

    public void dequeue() {
        if(q.size() == 0)
        {
            return;
        }
        if(q.size() == 1)
        {
            q.remove();
        }
        else // q size is greater than 1.
        {
            q.remove();
            List<Integer> list = new ArrayList<>();
            while(q.size() > 0)
            {
                list.add(q.peek().get(0));
                q.remove();
            }
            
            for(int val : list)
            {
                List<Integer> li = new ArrayList<>();
                if(q.size() == 0)
                {
                    li.add(val);
                    li.add(val);
                    li.add(val);
                    q.add(li);
                }
                else
                {
                    int maxIntBoth = Math.max(val, q.peekLast().get(1));
                    int minInBoth = Math.min(val, q.peekLast().get(2));
                    li.add(val);
                    li.add(maxIntBoth);
                    li.add(minInBoth);
                    q.add(li);
                }
                
            }
        }
    }

    public int getFront() {
        if(q.size() == 0)
        {
            return -1;
        }
        else
        {
            int val = q.peek().get(0);
            return val;
        }
    }

    public int getMin() {
        if(q.size() == 0)
        {
            return -1;
        }
        else
        {
            int val = q.peekLast().get(2);
            return val;
        }
    }

    public int getMax() {
        if(q.size() == 0)
        {
            return -1;
        }
        else
        {
            int val = q.peekLast().get(1);
            return val;
        }
    }
}