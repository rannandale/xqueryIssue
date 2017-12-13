xquery version "1.0" encoding "UTF-8";


declare function local:loopMe($nodes)
{
   for $node in $nodes

    return 
<variables>{$node/*:Name}</variables>


};

<o>

{local:loopMe(/root/Data)}

</o>

