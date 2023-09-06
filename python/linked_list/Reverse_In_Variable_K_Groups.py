

# Following is the class structure of the Node class:   
class Node:
    def __init__(self, data):
       	self.data = data
        self.next = None

def getListAfterReverseOperation(head, n, b):
    # Write your code here.
    k = b[0]
        

    if head==None or head.next == None:
        return head

    prev = None
    curr = head
    _next = head
    st = head

    if (not(k==1 or k==0)):
        prev = None
        curr = head
        _next = head

        st = head
        currCnt = 0
        while curr!=None and currCnt < k:
            _next = _next.next

            currCnt +=1

            curr.next = prev
            prev = curr
            curr = _next

        head = prev
        st.next = curr

    if (k==1):
        curr = curr.next

    it = 1

    while curr!=None:

        if it>=n:
            return head
        k = b[it]
        if curr.next==None:
            return head

        if (k==1):
            curr = curr.next
            it+=1
            continue
        if (k==0):
            it+=1
            continue

        hd = curr
        prev = None
        curr = hd
        _next = hd

        st.next = None

        t = st

        st = hd
        currCnt = 0
        while curr!=None and currCnt < k:
            _next = _next.next
            currCnt +=1
            curr.next = prev
            prev = curr
            curr = _next

        st.next=curr
        t.next = prev
        hd = curr
        
       

        it+=1
        

    
        
    return head
