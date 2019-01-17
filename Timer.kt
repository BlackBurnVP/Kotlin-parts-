class Timer{
    private val mHandler:Handler = Handler()
    private var mRunnable:Runnable = Runnable {  }
    private var seconds = 0
    private var startRun = false
    private var hours = 0
    private var minutes = 0
    private var secs = 0
    
    fun onTimerStart(){
      mRunnable = Runnable {
            hours = seconds/3600
            minutes = (seconds%3600)/60
            secs = (seconds%60)
            val time = String.format("%d:%02d:%02d", hours, minutes, secs)
            txtTime.text = time
            if (startRun){
                seconds++
                ed.putInt("SECONDS",seconds).commit()
            }
            mHandler.postDelayed(mRunnable,1000)
        }
        mHandler.postDelayed(mRunnable,1000)
    }
    
    fun onTimerStop(){
      mHandler.removeCallbacks(mRunnable)
    }
}
