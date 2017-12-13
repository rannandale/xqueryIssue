#Githyub project demonstraiting the issue I'm having with xquery since camel started using saxon 9.7
#Below is a copy of the mail sent to the camel users list

Hi guys

I think saxon went to 9.7 in camel 2.18 (could be 19). Anyway, I used the latest to illustrate my problem (2.20.1 at the time of writing)

I have a routes that receive XML payloads which I then transform via xqueries. Inside these I use local functions for readability (read: it’s the first thing I tried when solving my problem and it worked). 

Since saxon went to 9.7 I get a null pointer exception when an xquery containing a local function tries to process the XML.

To demonstrate this, I have made a GitHub project:
https://github.com/rannandale/xqueryIssue

In the project I use two xqueries to transform the same source. 
- One uses an inline for loop:
<o>
	<variables>{for $v in /root/Data return $v/Name}</variables>
</o>

- One uses the local function style:
declare function local:loopMe($nodes)
{
   for $node in $nodes
    return 
<variables>{$node/*:Name}</variables>
};

<o>
{local:loopMe(/root/Data)}
</o>

The latter is the one that returns the NPE.

I know I could probably go refactor all my xqueries to match the inline style, but I figured I’d see if there is an issue here other than PEBKAC. They also get quite complex, so it’s quite a bit of work.

The camel website says I should ask on the mailing list first before raising an issue, so here I am – first post and all.

Thanks guys
Riaan

