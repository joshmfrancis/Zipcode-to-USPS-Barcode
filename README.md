Created: 04/26/2022

This is an assignment for CSC 135 that I wrote code for. 
It asks for a ZIP Code input of 5 or 9, then creates a barcode format with ':' as short and '|' as long based on the old version of USPS Barcode formatting.

Here is what it should look like:

<img width="721" alt="Screen Shot 2022-04-26 at 1 48 20 AM" src="https://user-images.githubusercontent.com/104415326/165238989-435fbcc5-426e-4c70-a78b-cda81bd4fd28.png">

Here is a graph depicting the implementation digits of '0's as 'short' and '1's as 'long':

<img width="720" alt="Screen Shot 2022-04-26 at 1 49 57 AM" src="https://user-images.githubusercontent.com/104415326/165239488-dbe41251-1878-42d5-9424-c1fd8c8b55e2.png">

Here is a quick test of the program:

![image](https://user-images.githubusercontent.com/104415326/167322073-e55e3a00-583c-4738-9c31-6390d0f361a6.png)

This program also has a left and right bar frame along with a 'checkdigit' that verifies the number being converted. 
This program is split into two classes, one for encoding the barcode and the driver that handles the rest. 

Use Cases:
- This program would be useful for implementing a system that uses digits for identifying packages or other items and transferring it to a Barcode system that is quicker to scan by machines and has redundancy if the packaging number is damaged by dirt, mud, or a haphazard delivery driver. 

Problems:
- The program has an inherit flaw with how it asks for inputs. It asks for a ZIP Code as an integer, not a string. This means that if a digit is entered in that starts with a 0, it will ignore the digit (Thanks Java). 

Possible Work Arounds: 
 - Ask for the input as a string instead, and convert it from there. The way I have it converting, it just converts it to a string to check for the correct length, it does not check char by char when encoding to a barcode, which would be a better way to implement it. This would allow for more efficient code and an easier runtime. 
