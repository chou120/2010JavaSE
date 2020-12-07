1.创建两个线程，其中一个输出1-52，另外一个输出A-Z。输出格式要求：12A 34B 56C 78D

2.有四个线程,其中A,B线程对i加1操作，C,D线程每次对i减1操作    	CountDownLatch 工具类
  
  C   D  	   D--  C--
  
  A   B  	    A++  B++
  
  A B
  B A
  
  
  
  C D
  D C
  
  而不是这样:
  A++  D--  C--  B++      A++ B++  C-- D--       D-- C-- A++ B++
  D--  B++  A++  C--