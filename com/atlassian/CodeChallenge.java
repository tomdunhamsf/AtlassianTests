package com.atlassian;
import java.util.*;
import mapencoder.*;
import uniquecollection.*;
import lossychecker.*;
import findcommonancestor.*;
public class CodeChallenge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CodeChallenge chal = new CodeChallenge();
		System.out.println(chal.isConfusing());
		Map map = new HashMap();
		map.put("", "foo");
		map.put("bar","baz");
		map.put("bop","");
		MapEncoder me = new MyMapEncoder();
		Collection col = new ArrayList();
		col.add(new MyFullNameHelper.MyFullName("Tom","Dunham"));
		col.add(new MyFullNameHelper.MyFullName("Tom","Dunham"));
		col.add(new MyFullNameHelper.MyFullName("TomD","unham"));
		MyFullNameHelper mFNH=new MyFullNameHelper();
		Collection<FullName> col2=mFNH.getUnqiueFullNames(col);
		for (FullName el:col2){
			System.out.println(el.getFirstName()+el.getLastName());
		}
		System.out.println(me.encode(map));
		MyLossyChecker lossy=new MyLossyChecker();
		try{
		System.out.println(lossy.isLossy("\u00A3", "US-ASCII"));
		System.out.println(lossy.isLossy("abc", "UTF-8"));
		System.out.println(lossy.isLossy("abc", "foo"));
		}catch(Exception e){
			e.printStackTrace();
		}
		String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
		String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}; 
		String commit1 = "G";
		String commit2 = "E";
		MyFindCommonAncestor comAncestor=new MyFindCommonAncestor();
		System.out.println(comAncestor.findCommmonAncestor(commits, parents, commit1, commit2));
	}
	
	public boolean isConfusing() {
		   try {
		     return true;
		   } finally {
		     return false;
		   }
		}
}
