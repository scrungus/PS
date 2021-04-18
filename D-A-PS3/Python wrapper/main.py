import os
os.environ['CLASSPATH'] = "/home/scrungus/Documents/code/java/D-A-PS3/Python wrapper/Sorter.jar"
os.environ['JAVA_HOME'] = '/usr/lib/jvm/default' 
os.environ['JDK_HOME'] = '/usr/lib/jvm/default' 

from jnius import autoclass

sorter = autoclass('Sorter')
sorter = sorter()

Arrays = autoclass('java.util.Arrays')

sorter.insertionSort()

for p in sorter.permutations.toArray():
    print(Arrays.toString(p))

