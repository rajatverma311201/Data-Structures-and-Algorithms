package searching.binary_search.problems;

public class BookAllocation {



    public int bookAllocation(int[] bookPages, int students)
    {
        if(students>bookPages.length)
            return -1;

        int maxPage = bookPages[0];
        int totalPages = 0;
        for(int bookPage:bookPages)
        {
            totalPages+=bookPage;
            maxPage = Math.max(maxPage, bookPage);
        }

        int low = maxPage;
        int high = totalPages;

        while (low<=high)
        {
            int mid = low + (high-low)/2;

            int numStudents =  countStudentsforBooks(bookPages, mid);

            if (numStudents>students)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
    }

    public int countStudentsforBooks(int[] bookPages, int maxPages)
    {
        int students = 1;
        int cntPages = 0;
        for (int bookPage : bookPages) {
            if (cntPages + bookPage <= maxPages) {
                cntPages += bookPage;
            } else {
                students++;
                cntPages = bookPage;
            }
        }
        return students;
    }


}
