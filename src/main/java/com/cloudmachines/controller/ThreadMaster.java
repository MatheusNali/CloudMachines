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
	ArrayList<Future> Futures;

	Logging Log;
	ArrayList<Logging> ArrLogROI;
	ArrayList<Logging> ArrLogOnDemand;
	ArrayList<Logging> ArrLogDefineCost;

	int iDCliente = 42;
	int ID = 0;
	int maxThread = 5;
	int par_nMaq = 0;

	public ThreadMaster() {
		execService = Executors.newFixedThreadPool(maxThread);
		Futures = new ArrayList<Future>();
		ArrLogROI = new ArrayList<Logging>();
		ArrLogOnDemand = new ArrayList<Logging>();
		ArrLogDefineCost = new ArrayList<Logging>();
		Log = new Logging();
	}

	public void ROI(int nMaq) {

		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq < get_maxThread()) {
				PreencheLog(Log, iDCliente);
				Futures.add(execService.submit(new ROI()));
				ArrLogROI.add(Log);
				ID++;
				System.out.println("laa"+ArrLogROI.get(i).getMaqID());
			} else {
				i = nMaq;
			}
		}
	}

	public void OnDemand(int nMaq) {
		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq < get_maxThread()) {
				PreencheLog(Log, iDCliente);
				Futures.add(execService.submit(new OnDemand()));
				ArrLogOnDemand.add(Log);
				ID++;
			} else {
				i = nMaq;
			}
		}
	}

	public void DefineCost(int nMaq) {
		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq < get_maxThread()) {
				PreencheLog(Log, iDCliente);
				Futures.add(execService.submit(new DefineCost()));
				ArrLogDefineCost.add(Log);
				ID++;
			} else {
				i = nMaq;
			}
		}
	}

	public Logging getLog() {
		return Log;
	}

	public int get_maxThread() {
		par_nMaq++;
		return maxThread;
	}

	public void PreencheLog(Logging Log, int iDCliente) {
		Log.setDataIni(new Date());
		Log.setEstado(1);
		Log.setIDCliente(iDCliente);
		Log.setMaqID(ID);
	}

	public ArrayList<Future> getFutures() {
		return Futures;
	}

	public ArrayList<Logging> getArrLogROI() {
		return ArrLogROI;
	}

	public ArrayList<Logging> getArrLogOnDemand() {
		return ArrLogOnDemand;
	}

	public ArrayList<Logging> getArrLogDefineCost() {
		return ArrLogDefineCost;
	}
}
