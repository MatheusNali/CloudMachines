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

		}
	}
}

class OnDemand implements Runnable {

	public OnDemand() {

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

		}
	}

}

class DefineCost implements Runnable {

	public DefineCost() {

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

		}
	}

}

public class ThreadMaster {
	ExecutorService execService;
	ArrayList<Future> Futures;
	Logging Log;
	ArrayList<Logging> ArrLog;
	int iDCliente = 42;

	public ThreadMaster() {
		execService = Executors.newFixedThreadPool(5);
		Futures = new ArrayList<Future>();
		ArrLog = new ArrayList<Logging>();
		Log = new Logging();
	}

	public void ROI(int nMaq) {
		
		for (int i = 0; i < nMaq; i++) {
			PreencheLog(Log, iDCliente);
			ArrLog.add(Log);
			Futures.add(execService.submit(new ROI()));
			
		}
	}

	private void PreencheLog(Logging Log, int iDCliente) {
		Log.setDataIni(new Date());
		Log.setEstado(1);
		Log.setIDCliente(iDCliente);
		
	}

	public void OnDemand(int nMaq) {
		Futures.add(execService.submit(new OnDemand()));
	}

	public void DefineCost(int nMaq) {
		Futures.add(execService.submit(new DefineCost()));
	}
	
	public Logging getLog(){
		return Log;
	}
}
