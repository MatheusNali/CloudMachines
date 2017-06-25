package com.cloudmachines.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ROI implements Runnable {

	public ROI() {

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.currentThread();
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
		}
	}
}

class OnDemand implements Runnable {

	public OnDemand() {

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.currentThread();
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
		}
	}

}

class DefineCost implements Runnable {

	public DefineCost() {

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.currentThread();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
	
			}
		}
	}

}

public class ThreadMaster {

	ExecutorService execService;
	ArrayList<Future> FuturesROI;
	ArrayList<Future> FuturesOnDemand;
	ArrayList<Future> FuturesDefineCost;

	ArrayList<Logging> ArrLogROIAc;
	ArrayList<Logging> ArrLogOnDemandAc;
	ArrayList<Logging> ArrLogDefineCostAc;

	ArrayList<Logging> ArrLogROIIn;
	ArrayList<Logging> ArrLogOnDemandIn;
	ArrayList<Logging> ArrLogDefineCostIn;

	
	int iDCliente = 42;
	int ID = 0;
	int maxThread = 100;
	int par_nMaq = 0;

	public ThreadMaster() {
		execService = Executors.newFixedThreadPool(maxThread);
		FuturesROI = new ArrayList<Future>();
		FuturesOnDemand = new ArrayList<Future>();
		FuturesDefineCost = new ArrayList<Future>();
		ArrLogROIAc = new ArrayList<Logging>();
		ArrLogOnDemandAc = new ArrayList<Logging>();
		ArrLogDefineCostAc = new ArrayList<Logging>();
		ArrLogROIIn = new ArrayList<Logging>();
		ArrLogOnDemandIn = new ArrayList<Logging>();
		ArrLogDefineCostIn = new ArrayList<Logging>();

	}

	public void ROI(int nMaq) {

		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq < get_maxThread()) {
				ArrLogROIAc.add(PreencheLog());
				FuturesROI.add(execService.submit(new ROI()));
				ID++;

			} else {
				i = nMaq;
			}
		}
	}

	public void OnDemand(int nMaq) {
		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq < get_maxThread()) {
				FuturesOnDemand.add(execService.submit(new OnDemand()));
				ArrLogOnDemandAc.add(PreencheLog());
				ID++;
			} else {
				i = nMaq;
			}
		}
	}

	public void DefineCost(int nMaq) {
		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq < get_maxThread()) {
				FuturesDefineCost.add(execService.submit(new DefineCost()));
				ArrLogDefineCostAc.add(PreencheLog());
				ID++;
			} else {
				i = nMaq;
			}
		}
	}

	public int get_maxThread() {
		par_nMaq++;
		return maxThread;
	}

	public Logging PreencheLog() {
		Logging Log = new Logging();
		Log.setDataIni(new Date());
		Log.setEstado(1);
		Log.setIDCliente(iDCliente);
		Log.setMaqID(ID);
		
		return Log;
	}

	public ArrayList<Future> getFutures(int WhatFuture) {
		if(WhatFuture == 1)
			return FuturesROI;
		else if(WhatFuture == 2)
			return FuturesOnDemand;
		else if(WhatFuture == 3)
			return FuturesDefineCost;
		
		return null;
	}

	public ArrayList<Logging> getArrLogROI(int Type) {
		if(Type == 0)
			return ArrLogROIIn;
		else if(Type == 1)
			return ArrLogROIAc;
		return null;
	}

	public ArrayList<Logging> getArrLogOnDemand(int Type) {
		if(Type == 0)
			return ArrLogOnDemandIn;
		else if(Type == 1)
			return ArrLogOnDemandAc;
		return null;
	}

	public ArrayList<Logging> getArrLogDefineCost(int Type) {
		if(Type == 0)
			return ArrLogDefineCostIn;
		else if(Type == 1)
			return ArrLogDefineCostAc;
		return null;
	}
}
