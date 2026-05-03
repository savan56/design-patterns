package org.example.designPattern.structural.facade;

public class HotelReceptionFacade {
    private final HotelReservation hotelReservation;
    private final LaundryService laundryService;
    private final BookAShow bookAShow;
    private final RoomService roomService;

    public HotelReceptionFacade() {
        this.hotelReservation = new HotelReservation();
        this.laundryService = new LaundryService();
        this.bookAShow = new BookAShow();
        this.roomService = new RoomService();
    }

    public void planMyEvening(){
        bookAShow.bookAShow();
        hotelReservation.DinnerReservation();
        roomService.roomService();
    }

    public void getLaundryDone(){
        laundryService.laundryPickedUp();
    }
}
