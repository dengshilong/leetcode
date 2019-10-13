import threading


class H2O(object):
    def __init__(self):
        self.count = 0
        self.sh = threading.Semaphore(2)
        self.so = threading.Semaphore(0)


    def hydrogen(self, releaseHydrogen):
        """
        :type releaseHydrogen: method
        :rtype: void
        """
        self.sh.acquire()
        # releaseHydrogen() outputs "H". Do not change or remove this line.
        releaseHydrogen()
        self.count += 1
        if self.count == 2:
            self.so.release()
            self.count = 0

    def oxygen(self, releaseOxygen):
        """
        :type releaseOxygen: method
        :rtype: void
        """
        self.so.acquire()
        # releaseOxygen() outputs "O". Do not change or remove this line.
        releaseOxygen()
        self.sh.release()
        self.sh.release()
