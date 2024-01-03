package com.bitc.app0103

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bitc.app0103.databinding.ActivityDialogBinding
import java.util.Calendar

class DialogActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = arrayOf<String>("사과", "복숭아", "배", "수박")

        binding.btnToast.setOnClickListener {
            val text = binding.editTextMessage.text
            Toast.makeText(this, "입력한 메시지 : $text", Toast.LENGTH_SHORT).show()
            binding.editTextMessage.setText("")
        }

        binding.btnToastEvent.setOnClickListener {
            val text = binding.editTextMessage.text
            val toast = Toast.makeText(this, "입력한 메시지 : $text", Toast.LENGTH_SHORT)
            toast.addCallback(
                object : Toast.Callback(){
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("csy-toast", "토스트 메세지 숨겨질 때 동작하는 이벤트")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("csy-toast", "토스트 메시지가 출력될 때 동작하는 이벤트")
                    }
                }
            )
            toast.show()
        }

        binding.editTextDate.setOnClickListener{
//            날짜 및 시간 정보를 가지고 있는 Calendar 객체를 가져옴, 싱글톤 방식으로 구현되어 있음
            val calendar = Calendar.getInstance()
            var currentDate: String = ""

            val datePickerDialog = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("csy-datePicker", "년도 : $year, month : $month, dayOfMonth : $dayOfMonth")
                    currentDate = "${year}년 ${month+1}월 ${dayOfMonth}일"
                    binding.editTextDate.setText(currentDate)
                }
//                현재 시간을 기준으로 년, 월, 일 정보를 가져와서 DatePickerDialog에 설정함
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))


//            람다식을 사용한 방식
//            val test = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
//                    view, year, month, day ->
//                currentDate = "${year}년 ${month+1}월 ${day}일"
//                binding.editTextDate.setText(currentDate)
//            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

            datePickerDialog.show()
        }

        binding.editTextTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            var currentTime = ""

            val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, min ->
                Log.d("csy-timePicker", "설정 시간 : ${hour}시 ${min}분")
                currentTime ="${hour}시 ${min}분"
                binding.editTextTime.setText(currentTime)
            }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true)
            timePickerDialog.show()
        }

//        AlertDialog 의 클릭 이벤트를 한번에 처리
        val eventHandler = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    Toast.makeText(this@DialogActivity, "positive 버튼 클릭", Toast.LENGTH_SHORT).show()
                }
                else if(which == DialogInterface.BUTTON_NEGATIVE){
                    Toast.makeText(this@DialogActivity, "negative 버튼 클릭", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).run{
                setIcon(android.R.drawable.ic_dialog_info)
                setTitle("테스트 Alert Dialog")
                setMessage("종료하시겠습니까?")
                setPositiveButton("YES", eventHandler)
                setNegativeButton("NO", eventHandler)
            //        AlertDialog 의 각각의 버튼에 이벤트 리스너를 따로 구현한 방식
                setNeutralButton("More", DialogInterface.OnClickListener{
                    dialog, which ->
                    Toast.makeText(this@DialogActivity, "neutral 버튼 클릭", Toast.LENGTH_SHORT).show()
                })
//                AlertDialog 창 이외의 다른 부분을 클릭을 했을 경우 처리 방식 설정, 기본 값 true, false 사용 시 지정한 버튼을 클릭 해야만 AlertDialog 창이 닫힘
                setCancelable(false)
                show()
            }

//            AlertDialog 를 변수에 저장하여 필요할 때 호출
//            AlertDialog 에는 버튼을 3개까지만 사용할 수 있음, 중복되는 버튼은 나중에 입력한 내용으로 출력됨
//            val alertDialog = AlertDialog.Builder(this)
//            alertDialog.setTitle("AlertDialog 테스트 제목")
//            alertDialog.setMessage("테스트 메세지")
//            alertDialog.setPositiveButton("YES", null)
//            alertDialog.setNegativeButton("NO", null)
//            alertDialog.setNeutralButton("다른거", null)
//            alertDialog.setPositiveButton("예", null)
//            alertDialog.setNegativeButton("아니요", null)
//            alertDialog.show()
        }

        binding.btnAlertList.setOnClickListener {


            AlertDialog.Builder(this).run {
                setIcon(android.R.drawable.ic_dialog_info )
                setTitle("Alert 다이얼로그에 목록 출력")
                setItems(items, DialogInterface.OnClickListener{
                    dialog, which ->
                    Log.d("csy-alertDialog", "선택한 과일 : ${items[which]}")
                    Toast.makeText(this@DialogActivity, "선택한 과일 : ${items[which]}", Toast.LENGTH_SHORT).show()
                })
                setPositiveButton("닫기", null)
                show()
            }
        }

        binding.btnAlertCheckBox.setOnClickListener {
//            선택한 문자열을 저장하기 위한 리스트 객체
            val selectItems = mutableListOf<String>()

            AlertDialog.Builder(this).run {
                setIcon(android.R.drawable.ic_dialog_info)
                setTitle("Alert 다이얼로그에 체크박스 출력")
                setMultiChoiceItems(items, booleanArrayOf(true, false, false, false), object : DialogInterface.OnMultiChoiceClickListener{
//                    which : 사용자가 선택한 체크박스의 index 번호
//                    isChecked : 사용자가 선택한 체크박스 선택 여부 값, true/false
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        Toast.makeText(this@DialogActivity, "${items[which]} ${if(isChecked) "선택되었습니다." else "선택 해제되었습니다."}", Toast.LENGTH_SHORT).show()

                        if(isChecked){
                            selectItems.add(items[which])
                        }
                        else{
                            if(selectItems.contains(items[which])){
                                selectItems.remove(items[which])
                            }
                        }
                    }
                })
                setPositiveButton("닫기", {
                    dialog, which ->
                    var text = selectItems.joinToString(",")

                    Toast.makeText(this@DialogActivity, "선택한 과일 : $text", Toast.LENGTH_SHORT).show()
                })
                show()
            }
        }

        binding.btnAlertRadio.setOnClickListener {
            var selectItem: String =""

            AlertDialog.Builder(this).run{
                setIcon(android.R.drawable.ic_dialog_info)
                setTitle("Alert 다이얼로그에 라디오버튼 출력")
//                AlertDialog에 라디오버튼을 추가하는 메소드
                setSingleChoiceItems(items, 0, object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
//                        Toast.makeText(this@DialogActivity, "${items[which]} 선택되었습니다.", Toast.LENGTH_SHORT).show()
                        selectItem = items[which]
                    }
                })
                setPositiveButton("닫기", {
                    dialog, which ->
                    Toast.makeText(this@DialogActivity, "선택한 과일 $selectItem", Toast.LENGTH_SHORT).show()
                })
                show()
            }
        }
    }
}















