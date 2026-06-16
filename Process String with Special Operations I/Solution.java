class Solution {
    public String processStr(String s) {
        StringBuilder res=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(ch>='a' && ch<='z')
            {
                res.append(ch);
            }
            else if(ch=='*')
            {
                if(res.length()>0)
                {
                    res.deleteCharAt(res.length()-1);
                }
            }
            else if(ch=='#')
            {
                res.append(res.toString());
            }
            else
            {
                res.reverse();
            }
        }
        return res.toString();
    }
}