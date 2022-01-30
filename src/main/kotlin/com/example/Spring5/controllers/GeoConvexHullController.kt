package com.example.Spring5.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.collections.ArrayDeque

@RestController
@RequestMapping("/geo/convex-hull")
class GeoConvexHullController {

    @GetMapping("/graham-scan")
    fun grahamScan() {
        val points = listOf(
            // Q1
            Point(1, 1),
            Point(2, 3),
            // Q2
            Point(-2, 2),
            Point(-3, 4),
            // Q3
            Point(-1, -2),
            Point(-4, -4),
            // Q4
            Point(3, -3),
            Point(5, -5),
        )
        val result = calcGrahamScan(points)
    }

    // https://www.youtube.com/watch?v=B2AJoQSZf4M
    private fun <T> calcGrahamScan(points: List<Point<T>>): List<Point<T>> {
        val pointsStack = ArrayDeque<Point<T>>()
        val minYPoint = MinYPoint(points)
        val sortedPoints = SortByAngle(points, minYPoint)

        // Push sortedPoints[0] (minYPoint) to stack
        // Push the next sortedPoints[1]  to stack

        // Iterate points from [2] as i
        // next = Get point i (2, 3, 4 etc)
        // p = Delete last added point in stack (pop)
        // Is not at end of stack, or makes a clock wise turn with last popped or the next
        //  p = pop the stack again
        // stack.push(p)
        // stack.push(next)

        // Check colinear
        // p = Get the last pushed point
        // If the next point in stack makes a clock wise turn to the last point of the minYPoint
        //  put p back on the stack

        return pointsStack.toList()
    }
}

 data class Point<T>(
    val x: T,
    val y: T
)

fun <T> MinYPoint(points: List<Point<T>>): Point<T> {
    // TODO
    val point = points.first()
    return point
}

fun <T> SortByAngle(points: List<Point<T>>, minYPoint: Point<T>): List<Point<T>> {
    // TODO
    return points
}