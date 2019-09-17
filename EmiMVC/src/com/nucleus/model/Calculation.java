package com.nucleus.model;



public class Calculation
	{
		
		double principalAmount,tenure,rateOfInterest,noOfInstallments=12;
			
		
		

			
			 double interest, outstandingPrincipal, principalComp;
			 double installmentAmount;
			
			 public double  EmiCal(UserClass userClass)
				{
				 
				 double noOfInstallments=12;
			
					  double a=(userClass.getPrincipalAmount())*(((userClass.getRateOfInterest())/100)/noOfInstallments);
					  double b=1+(((userClass.getRateOfInterest()/100))/noOfInstallments);
					double c=Math.pow(b,userClass.getTenure());
					double d=1-1/c;
					
				   double  installmentAmount=a/d;
		
					return installmentAmount;
					
				}
	
		
			public double interests(UserClass userClass)
			{
			  interest=(outstandingPrincipal*((userClass.getRateOfInterest())/100))/12;
			  return interest;
			}
			 public double prinComp(UserClass userClass)
			 {
				 
				  double i=interests(userClass);
				   double intallment= EmiCal(userClass);
				  
				 principalComp=intallment-i;
				 return principalComp;

			 }
		     
			 public double outP(UserClass userClass)
			 {
				 if(outstandingPrincipal==0.0)
				 {
					 outstandingPrincipal=userClass.getPrincipalAmount();
				
				 }
				 else
				 {
					 outstandingPrincipal=outstandingPrincipal-principalComp;
					
				 }
				 return outstandingPrincipal;
			 }
			 
			 
			public double Month(UserClass userClass)
			 {
				
				double n=userClass.getMonth();
				 return n;
				 
				 
				 
			 }
	}
	
		
