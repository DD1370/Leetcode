class Solution {
static final long MOD1 = 1_000_000_007L;
static final long MOD2 = 1_000_000_009L;
static final long BASE = 911382323L;
public String longestDupSubstring(String s) {
int n = s.length();
long[] h1 = new long[n+1];
long[] h2 = new long[n+1];
long[] p1 = new long[n+1];
long[] p2 = new long[n+1];
p1[0] = 1;
p2[0] = 1;
for(int i = 0; i<n; i++){
int value = s.charAt(i) - 'a' +1;
h1[i+1] = (h1[i]*BASE + value)%MOD1;
h2[i+1] = (h2[i]*BASE + value)%MOD2;
p1[i+1] = (p1[i]*BASE)%MOD1;
p2[i+1] = (p2[i]*BASE)%MOD2;
}
//binary search
int left = 1;
int right = n-1;
int ansStart = 0;
int ansLen = 0;
while(left <= right){
int len = left+(right - left)/2 ;
int start = check(s, len, h1, h2, p1, p2);

if(start != -1){
ansStart = start;
ansLen = len;
left = len+1;
}else{
right = len-1;
}
}return s.substring(ansStart, ansStart+ansLen);
}
public static int check(String s, int len, long[] h1, long[] h2, long[] p1, long[] p2){
HashMap<Long, Integer> map = new HashMap<>();
for(int i = 0; i+len <= s.length(); i++){
long hash1 = (h1[i+len] - (h1[i]*p1[len]%MOD1)+MOD1)%MOD1;
long hash2 = (h2[i+len] - (h2[i]*p2[len]%MOD2)+MOD2)%MOD2;
long key = (hash1 << 32) ^ hash2;
if(map.containsKey(key)){
int previousStart = map.get(key);
if(s.regionMatches(previousStart, s, i,len)){
return i;
}
}map.putIfAbsent(key,i);
}return -1;
}
}